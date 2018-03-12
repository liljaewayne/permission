package top.liujianwei.beans;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
/**
 * 分页列表结果实体
 */
public class PageResult<T> {

    private List<T> data = Lists.newArrayList();

    private int total = 0;
}
