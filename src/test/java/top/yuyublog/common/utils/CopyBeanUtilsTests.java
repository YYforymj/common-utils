package top.yuyublog.common.utils;

import org.junit.Test;
import top.yuyublog.common.utils.bean.Bean1;
import top.yuyublog.common.utils.bean.Bean2;

import static org.junit.Assert.assertEquals;

/**
 * @author yumj
 * @createTime 2021/1/14
 */
public class CopyBeanUtilsTests {

    @Test
    public void testCopyBean() {
        Bean1 src = new Bean1(1, 1L, "1");
        CopyBeanUtils<Bean1, Bean2> copyBeanUtils = new CopyBeanUtils<>();
        Bean2 dest1 = new Bean2();
        copyBeanUtils.copyProperties(src, dest1);
        Bean2 dest2 = new Bean2();
        CopyBeanUtils<Bean1, Bean2> copyBeanUtilsBeanCopier = new CopyBeanUtils<>(CopyBeanUtils.ImplementEnum.CGLIB_BEAN_COPIER);
        copyBeanUtilsBeanCopier.copyProperties(src, dest2);
        assertEquals(dest1, dest2);
    }
}
