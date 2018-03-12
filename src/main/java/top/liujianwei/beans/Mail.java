package top.liujianwei.beans;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * 邮件
 */
public class Mail {

    private String subject;

    private String message;

    private Set<String> receivers;
}
