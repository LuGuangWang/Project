package wlg.javaapi.resource;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

public class LoaderClass {

  void loadResources(){
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Set<AnnotationMetadata> configurationClasses = new HashSet<AnnotationMetadata>();
    try {
      String locationPattern = "classpath*:" + getClass().getPackage().getName().replace(".", "/") + "/**/*.class";
      Resource[] resources = resolver.getResources(locationPattern);
      System.out.println(locationPattern);
      for (Resource resource : resources) {
        System.out.println(resource.getFilename());
        MetadataReader metadataReader = new SimpleMetadataReaderFactory()
            .getMetadataReader(resource);
        AnnotationMetadata annotationMetadata = metadataReader
            .getAnnotationMetadata();
        if (annotationMetadata.getAnnotationTypes()
            .contains(Configuration.class.getName())) {
          configurationClasses.add(annotationMetadata);
        }
      }
      System.out.println(configurationClasses.size());
    } catch (IOException e) {
    }
  }
  
  public static void main(String[] args){
    LoaderClass instance = new LoaderClass();
    instance.loadResources();
  }
}
