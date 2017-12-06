package com.java.rehber.cc;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily="javax.faces.Output",rendererType="com.rehber.menurenderer")
public class MenuItemRenderer extends Renderer {
	
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter responseWriter = context.getResponseWriter();
		UIMenuItem menuItem = (UIMenuItem) component;
		String pageName = component.getAttributes().get("pageName").toString();
		String pageUrl = component.getAttributes().get("pageUrl").toString();
		String pageIcon = component.getAttributes().get("pageIcon").toString();
		
		String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		
		responseWriter.startElement("li", menuItem);
		if (viewId.equals("/" + pageUrl)){
			responseWriter.writeAttribute("class","active" , null);
		}
		responseWriter.startElement("a", menuItem);
		responseWriter.writeAttribute("href", pageUrl , null);
		responseWriter.startElement("i", menuItem);
		responseWriter.writeAttribute("class", pageIcon , null);
		responseWriter.endElement("i");
		responseWriter.write(pageName);
		responseWriter.endElement("a");
		responseWriter.endElement("li");
		
		//		<li class="#{view.viewId == '/user.xhtml' ? 'active' : ''}"><a
//				href="user.xhtml"> <i class="null"></i>
//					${cmsg['rehber.management.page']}
//			</a></li>
	}
}
