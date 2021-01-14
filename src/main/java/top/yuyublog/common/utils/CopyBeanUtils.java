package top.yuyublog.common.utils;

import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 类属性复制工具
 *
 * @author yumj
 * @createTime 2021/1/14
 */
public class CopyBeanUtils<T, U> {
    private ImplementEnum implementEnum;

    public CopyBeanUtils() {
        this.implementEnum = ImplementEnum.APACHE_BEAN_UTILS;
    }

    public CopyBeanUtils(ImplementEnum implementEnum) {
        this.implementEnum = implementEnum;
    }

    public void copyProperties(T src, U dest) {
        switch (this.implementEnum) {
            case APACHE_BEAN_UTILS:
                try {
                    BeanUtils.copyProperties(dest, src);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            case CGLIB_BEAN_COPIER:
                BeanCopier copier = BeanCopier.create(src.getClass(), dest.getClass(), false);
                copier.copy(src, dest, null);
                return;
            default:
        }
    }


    public enum ImplementEnum {
        CGLIB_BEAN_COPIER("cglib_bean_copier"),
        APACHE_BEAN_UTILS("apache_bean_utils"),
        ;

        private String implement;

        ImplementEnum(String implement) {
            this.implement = implement;
        }
    }

}
