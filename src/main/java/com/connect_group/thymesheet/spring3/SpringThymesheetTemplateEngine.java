/*
 * =============================================================================
 *
 *   Copyright (c) 2013, Connect Group (http://www.connect-group.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.connect_group.thymesheet.spring3;

import com.connect_group.thymesheet.templatemode.IThymesheetTemplateModeHandler;
import com.connect_group.thymesheet.templatemode.ThymesheetStandardTemplateModeHandlers;
import org.springframework.web.context.ServletContextAware;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templatemode.ITemplateModeHandler;

import javax.servlet.ServletContext;
import java.util.Set;

public class SpringThymesheetTemplateEngine extends SpringTemplateEngine implements ServletContextAware {

	private SpringServletContextURLFactory urlFactory;
	
	public SpringThymesheetTemplateEngine() {
		super();
		urlFactory = new SpringServletContextURLFactory();
		initialiseTemplateModeHandlers(ThymesheetStandardTemplateModeHandlers.ALL_TEMPLATE_MODE_HANDLERS);
		setDefaultTemplateModeHandlers(ThymesheetStandardTemplateModeHandlers.ALL_TEMPLATE_MODE_HANDLERS);
	}
	
	public void setServletContext(ServletContext servletContext) {
		urlFactory.setServletContext(servletContext);
	}
	
	@Override
	public void setTemplateModeHandlers(Set<? extends ITemplateModeHandler> templateModeHandlers) {
		initialiseTemplateModeHandlers(templateModeHandlers);
		super.setTemplateModeHandlers(templateModeHandlers);
	}

	@Override
	public void addTemplateModeHandler(ITemplateModeHandler templateModeHandler) {
		initialiseTemplateModeHandler(templateModeHandler);
		super.addTemplateModeHandler(templateModeHandler);
	}

	private void initialiseTemplateModeHandlers(Set<? extends ITemplateModeHandler> handlers) {
		for(ITemplateModeHandler handler : handlers) {
			initialiseTemplateModeHandler(handler);
		}		
	}
	
	private void initialiseTemplateModeHandler(ITemplateModeHandler handler) {
		if(handler instanceof IThymesheetTemplateModeHandler && ((IThymesheetTemplateModeHandler) handler).getUrlFactory()==null) {
			((IThymesheetTemplateModeHandler) handler).setUrlFactory(urlFactory);
		}
	}

}
