package cn.vorbote.commons.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This util is to convert a {@code ResultSet} to several rows.
 *
 * @author vorbote thills@vorbote.cn
 */
public final class DatabaseUtil {

    private DatabaseUtil() {
    }

    /**
     * Convert a result set to rows.
     * @param rs The result set.
     * @return A list contains all data in result set.
     * @throws SQLException May throw a SQL Exception.
     */
    public static List<Map<String, Object>> ConvertList(ResultSet rs) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            Map<String, Object> rowData = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(metaData.getColumnName(i), rs.getObject(i));
            }
            list.add(rowData);
        }
        return list;
    }
}
