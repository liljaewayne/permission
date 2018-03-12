package top.liujianwei.util;

import org.apache.commons.lang3.StringUtils;

public class LevelUtil {

    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";


    /**
     * 计算当前部门的层级, 格式如下:
     * 0        - 第一层
     * 0.1      - 第二层, 父亲的id为1
     * 0.1.2    - 第三层, 父亲的id为2, 爷爷的id为1
     * 0.1.3
     * 0.4
     *
     * @param parentLevel
     * @param parentId
     * @return
     */
    public static String calculateLevel(String parentLevel, int parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;
        } else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);
        }
    }
}
