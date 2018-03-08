package top.liujianwei.model;

/**
 * 表中存在text的字段, 生成的实体类会存在这种情况, 选择性的使用bolb实体类, 避免text字段对性能的开销太大
 */
public class SysLogWithBLOBs extends SysLog {
    private String oldValue;

    private String newValue;

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue == null ? null : oldValue.trim();
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue == null ? null : newValue.trim();
    }
}