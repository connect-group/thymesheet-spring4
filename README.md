thymesheet-spring4
==================

Thymesheet integration module for Spring 4

# Maven

		<dependency>
			<groupId>com.connect-group</groupId>
			<artifactId>thymesheet-spring4</artifactId>
			<version>2.1.2</version>
		</dependency>

# Spring Configuration

    <bean id="templateEngine"
          class="com.connect_group.thymesheet.spring4.SpringThymesheetTemplateEngine">
      <property name="templateResolver" ref="templateResolver" />
      <property name="additionalDialects">
        <set>
            <bean class="com.connect_group.thymesheet.sample.dialect.SampleDialect"/>
        </set>
      </property>
    </bean>
