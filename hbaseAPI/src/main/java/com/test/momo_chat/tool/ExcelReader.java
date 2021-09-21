package com.test.momo_chat.tool;



import com.test.momo_chat.entity.Msg;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

public class ExcelReader {
    private static Logger log = Logger.getLogger("client");

    public static void main(String[] args) {
        String xlxsPath = "hbaseAPI/datas/测试数据集.xlsx";
        //用于读取Excel中的数据，返回每一列String，以及这一列对应的所有值List<String>
        Map<String, List<String>> mapData = readXlsx(xlxsPath, "陌陌数据");

//        for(int i = 0; i < 10000; ++i) {
//            System.out.println(randomColumn(mapData, "sender_nickyname"));
//        }
        //模拟生成一条数据
        System.out.println(getOneMsg(mapData));
    }

    /**
     * 随机获取某一列的数据
     * @param columnName 列名
     * @return 随机数据
     */
    public static String randomColumn(Map<String, List<String>> resultMap, String columnName) {
        List<String> valList = resultMap.get(columnName);

        if(valList == null) {
            throw new RuntimeException("未读取到列名为" + columnName + "的任何数据!");
        }
        Random random = new Random();

        int randomIndex = random.nextInt(valList.size());

        return valList.get(randomIndex);
    }

    /**
     * 将Excel文件读取为Map结构: <column_name, list>
     * 其中column_name为第4行的名字
     * @param path Excel文件路径（要求Excel为2007）
     * @param sheetName 工作簿名称
     * @return Map结构
     */
    public static Map<String, List<String>> readXlsx(String path, String sheetName)
    {
        // 列的数量
        int columnNum = 0;
        HashMap<String, List<String>> resultMap = new HashMap<String, List<String>>();
        ArrayList<String> columnList = new ArrayList<String>();

        try
        {
            OPCPackage pkg= OPCPackage.open(path);
            XSSFWorkbook excel=new XSSFWorkbook(pkg);
            //获取sheet
            XSSFSheet sheet=excel.getSheet(sheetName);

            // 加载列名
            XSSFRow columnRow = sheet.getRow(3);
            if(columnRow == null) {
                throw new RuntimeException("数据文件读取错误!请确保第4行为英文列名!");
            }
            else {
                Iterator<Cell> colIter = columnRow.iterator();
                // 迭代所有列
                while(colIter.hasNext()) {
                    Cell cell = colIter.next();
                    String colName = cell.getStringCellValue();
                    columnList.add(colName);
                    columnNum++;
                }
            }

//            System.out.println("读取到:" + columnNum + "列");
//            System.out.println(Arrays.toString(columnList.toArray()));

            // 初始化resultMap
            for(String colName : columnList) {
                resultMap.put(colName, new ArrayList<String>());
            }

            // 迭代sheet
            Iterator<Row> iter = sheet.iterator();
            int i = 0;
            int rownum = 1;

            while(iter.hasNext()) {
                Row row = iter.next();
                Iterator<Cell> cellIter = row.cellIterator();

                // 跳过前4行
                if(rownum <= 4) {
                    ++rownum;
                    continue;
                }

                while(cellIter.hasNext()) {
                    XSSFCell cell=(XSSFCell) cellIter.next();
                    //根据单元的的类型,读取相应的结果
                    if(cell.getCellType() == CellType.NUMERIC) {
                        resultMap.get(columnList.get(i % columnList.size())).add(Double.toString(cell.getNumericCellValue()));
                    }
                    else {
                        resultMap.get(columnList.get(i % columnList.size())).add(cell.getStringCellValue());
                    }

                    ++i;
                    ++rownum;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;
    }

    public static Msg getOneMsg(Map<String, List<String>> resultMap) {
        Msg msg = new Msg();
        long timestamp = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        msg.setMsg_time(sdf.format(timestamp));
        msg.setSender_nickyname(ExcelReader.randomColumn(resultMap, "sender_nickyname"));
        msg.setSender_account(ExcelReader.randomColumn(resultMap, "sender_account"));
        msg.setSender_sex(ExcelReader.randomColumn(resultMap, "sender_sex"));
        msg.setSender_ip(ExcelReader.randomColumn(resultMap, "sender_ip"));
        msg.setSender_os(ExcelReader.randomColumn(resultMap, "sender_os"));
        msg.setSender_phone_type(ExcelReader.randomColumn(resultMap, "sender_phone_type"));
        msg.setSender_network(ExcelReader.randomColumn(resultMap, "sender_network"));
        msg.setSender_gps(ExcelReader.randomColumn(resultMap, "sender_gps"));
        msg.setReceiver_nickyname(ExcelReader.randomColumn(resultMap, "receiver_nickyname"));
        msg.setReceiver_ip(ExcelReader.randomColumn(resultMap, "receiver_ip"));
        msg.setReceiver_account(ExcelReader.randomColumn(resultMap, "receiver_account"));
        msg.setReceiver_os(ExcelReader.randomColumn(resultMap, "receiver_os"));
        msg.setReceiver_phone_type(ExcelReader.randomColumn(resultMap, "receiver_phone_type"));
        msg.setReceiver_network(ExcelReader.randomColumn(resultMap, "receiver_network"));
        msg.setReceiver_gps(ExcelReader.randomColumn(resultMap, "receiver_gps"));
        msg.setReceiver_sex(ExcelReader.randomColumn(resultMap, "receiver_sex"));
        msg.setMsg_type(ExcelReader.randomColumn(resultMap, "msg_type"));
        msg.setDistance(ExcelReader.randomColumn(resultMap, "distance"));
        msg.setMessage(ExcelReader.randomColumn(resultMap, "message"));

        return msg;
    }



}

