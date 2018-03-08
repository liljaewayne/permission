package top.liujianwei.util;

import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import top.liujianwei.exception.ParamException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// TODO 列表校验没有实现
public class BeanValidator {
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    /**
     * 校验一个vo的参数合法性
     *
     * @param t      vo
     * @param groups the group or list of groups targeted for validation (defaults to {@link Default})
     * @param <T>
     * @return
     */
    public static <T> Map<String, String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();

        Set validateResult = validator.validate(t, groups);
        if (validateResult.isEmpty()) {
            return Collections.emptyMap();
        } else {
            LinkedHashMap<String, String> errors = Maps.newLinkedHashMap();

            validateResult.forEach((validateResultItem) -> {
                ConstraintViolation violation = (ConstraintViolation) validateResultItem;
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            });

            return errors;
        }
    }

    /**
     * 校验多个vo的参数合法性
     *
     * @param collection
     * @return
     */
    /*public static Map<String, String> validateList(Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        Iterator iterator = collection.iterator();
        Map errors;

        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();
            }
            Object object = iterator.next();
            errors = validate(object, new Class[0]);
        } while (errors.isEmpty());

        return errors;
    }*/


    /**
     * just route
     *
     * @param first
     * @param objects
     * @return
     */
    /*private static Map<String, String> validateObject(Object first, Object... objects) {
        if (objects != null && objects.length > 0) {
            return validateList(Lists.asList(first, objects));
        } else {
            return validate(first, new Class[0]*//*redundant: 多余的*//*);
        }
    }*/

    /**
     * general interface for validate
     *
     * @param object vo or vos
     * @throws ParamException
     */
    public static void check(Object object) throws ParamException {
//        Map<String, String> map = BeanValidator.validateObject(object);

        Map<String, String> map = BeanValidator.validate(object);
        if (MapUtils.isNotEmpty(map)) {
            throw new ParamException(map.toString());
        }
    }

}
