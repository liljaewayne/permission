package top.liujianwei.param;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestVo {

    @NotNull(message = "不能为空")
    @Min(1)
    @Max(value = 100, message = "不能大于100")
    private Integer id;

    @NotBlank
    private String msg;

//    @NotEmpty
    private List<String> strs;
}
