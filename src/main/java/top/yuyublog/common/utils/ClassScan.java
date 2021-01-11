package top.yuyublog.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassScan {

	// 所有的controller包名
	private static List<String> controllerPackageList = new ArrayList<>();
	/**
	 * 扫描给定的基包下的所有的类(包括子包)。
	 * @param basePackageName 基包的名称
	 * @return 所有在基包下的类的全名
	 */
	public static Set<String> scanBasePackage(String basePackageName){
		String packageDirName = basePackageName.replace(".", "/");
		URL url  = Thread.currentThread().getContextClassLoader().getResource(packageDirName);
		System.out.println(url);
		File targetFile = new File(url.getFile());
		if(!targetFile.exists() || targetFile.isFile()){
			throw new RuntimeException(basePackageName + "不是一个包名或者该包名不存在");
		}
		Set<String> classNames = new HashSet<String>();
		getAllClass(targetFile, basePackageName, classNames);
		controllerPackageList = controllerPackageList.stream().distinct().collect(Collectors.toList());
		return classNames;
		
	}
	/**
	 * 得到所有在parentFile目录下的class文件名称
	 * @param parentFile 
	 * @param classNames
	 * @param basePackageName 
	 */
	private static void getAllClass(File parentFile, String basePackageName, Set<String> classNames){
			
		File[] files = parentFile.listFiles();
		for(File file : files){
			String path = file.getPath();
			if(file.isFile()){
				// 只添加控制器
				if(path.endsWith(".class")){
					controllerPackageList.add(basePackageName);
					classNames.add(basePackageName + "."
							+ path.substring(path.lastIndexOf('\\') + 1, path.lastIndexOf('.')));
				}
			}else{
				String newBasePackageName = basePackageName + "." + path.substring(path.lastIndexOf('\\') + 1);
				getAllClass(file, newBasePackageName, classNames);
			}
		}
	}


	public static void main(String[] args) {
		String basePackageName = "top.yuyublog.common.utils";
		Set<String> classNames = scanBasePackage(basePackageName);
		System.out.println(JSONObject.toJSONString(classNames));
	}
}