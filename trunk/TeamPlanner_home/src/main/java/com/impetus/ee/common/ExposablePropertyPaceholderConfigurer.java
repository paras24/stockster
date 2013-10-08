package com.impetus.ee.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Bean that should be used instead of the {@link PropertyPlaceholderConfigurer} if you want to have
 * access to the resolved properties not obly from the Spring context. e.g. from JSP or so. More
 * details about usage here http://wiki.sonopia.com/x/GmQ
 * 
 * @author Mykola Palienko
 */
public class ExposablePropertyPaceholderConfigurer extends PropertyPlaceholderConfigurer {

  private Map<String, String> resolvedProps;

  @Override
  protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,
      Properties props) throws BeansException {
      super.processProperties(beanFactoryToProcess, props);
      resolvedProps = new HashMap<String, String>();
      for (Object key : props.keySet()) {
          String keyStr = key.toString();
          resolvedProps.put(keyStr, parseStringValue(props.getProperty(keyStr), props,
                  new HashSet()));
      }
  }

  public Map<String, String> getResolvedProps() {
      return Collections.unmodifiableMap(resolvedProps);
  }

}