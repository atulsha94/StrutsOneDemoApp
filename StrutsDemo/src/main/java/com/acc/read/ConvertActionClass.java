/*
 * package com.acc.read;
 * 
 * import java.util.LinkedList; import java.util.List; import java.util.Set;
 * 
 * import org.apache.struts.action.Action; import org.reflections.Reflections;
 * import org.reflections.scanners.ResourcesScanner; import
 * org.reflections.scanners.SubTypesScanner; import
 * org.reflections.util.ClasspathHelper; import
 * org.reflections.util.ConfigurationBuilder; import
 * org.reflections.util.FilterBuilder;
 * 
 * public class ConvertActionClass {
 * 
 * public static void convert() { System.out.println("inside"); try {
 * List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
 * classLoadersList.add(ClasspathHelper.contextClassLoader());
 * classLoadersList.add(ClasspathHelper.staticClassLoader());
 * 
 * Reflections reflections = new Reflections(new ConfigurationBuilder()
 * .setScanners(new SubTypesScanner(false don't exclude Object.class ), new
 * ResourcesScanner())
 * .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new
 * ClassLoader[0]))) .filterInputsBy(new
 * FilterBuilder().include(FilterBuilder.prefix("com")))); Set<Class<? extends
 * Action>> classes = reflections.getSubTypesOf(Action.class);
 * System.out.println("size "+classes.size()); for(Class< ? extends
 * Object>classv :classes) { System.out.println(classv.getName()); }
 * }catch(Exception e) { e.printStackTrace(); } } public static void
 * main(String[] args) { try{ convert(); } catch(Exception e) {
 * e.printStackTrace(); } } }
 */