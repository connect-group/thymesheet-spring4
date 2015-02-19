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

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;

import com.connect_group.thymesheet.ServletContextURLFactory;

public class SpringServletContextURLFactory implements ServletContextURLFactory {

	private ServletContext servletContext;
	
	public SpringServletContextURLFactory() {
		super();
	}
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	public URL getURL(String filePath) throws MalformedURLException {
		return servletContext.getResource(filePath);
	}

}
