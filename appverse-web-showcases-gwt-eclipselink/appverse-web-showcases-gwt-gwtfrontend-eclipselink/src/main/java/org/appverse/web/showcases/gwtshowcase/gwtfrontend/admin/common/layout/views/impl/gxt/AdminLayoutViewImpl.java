/*
 Copyright (c) 2012 GFT Appverse, S.L., Sociedad Unipersonal.

 This Source Code Form is subject to the terms of the Mozilla Public 
 License, v. 2.0. If a copy of the MPL was not distributed with this 
 file, You can obtain one at http://mozilla.org/MPL/2.0/. 

 Redistribution and use in source and binary forms, with or without modification, 
 are permitted provided that the conditions of the Mozilla Public License v2.0 
 are met.

 THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 DISCLAIMED. EXCEPT IN CASE OF WILLFUL MISCONDUCT OR GROSS NEGLIGENCE, IN NO EVENT
 SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE) 
 ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 POSSIBILITY OF SUCH DAMAGE.
 */
package org.appverse.web.showcases.gwtshowcase.gwtfrontend.admin.common.layout.views.impl.gxt;

import org.appverse.web.framework.frontend.gwt.rmvp.ReverseComposite;
import org.appverse.web.showcases.gwtshowcase.gwtfrontend.admin.common.layout.presenters.interfaces.AdminLayoutView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.sencha.gxt.core.client.XTemplates;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

@Singleton
public class AdminLayoutViewImpl extends
		ReverseComposite<AdminLayoutView.IAdminLayoutPresenter> implements
		AdminLayoutView {

	interface BodyUiBinder extends UiBinder<Widget, AdminLayoutViewImpl> {
	}

	public interface HtmlLayoutContainerTemplate extends XTemplates {
		@XTemplate("<div class=\"leftFrame\"></div><div class=\"content\"></div><div class=\"rightFrame\"></div>")
		SafeHtml getTemplate();
	}

	private static BodyUiBinder uiBinder = GWT.create(BodyUiBinder.class);

	@Inject
	@UiField(provided = true)
	AdminHeaderViewImpl adminHeader;

	@Inject
	@UiField(provided = true)
	AdminMenuViewImpl adminMenu;

	@UiField
	ContentPanel body;

	@UiField
	VerticalLayoutContainer flow;

	@UiField
	BorderLayoutContainer borderCon;

	private void centerBorderLayout() {
		int width = Window.getClientWidth();
		int desiredWidth = 1024;
		int leftMargin = (width - desiredWidth) / 2;
		if (leftMargin < 0)
			leftMargin = 0;
		borderCon.setPosition(leftMargin, 0);
	}

	@Override
	public void createView() {
		initWidget(uiBinder.createAndBindUi(this));
		flow.setScrollMode(ScrollMode.AUTO);
		flow.setHeight(Window.getClientHeight() - 40);
		centerBorderLayout();
		Window.addResizeHandler(new ResizeHandler() {
			@Override
			public void onResize(final ResizeEvent event) {
				centerBorderLayout();
			}
		});
	}

	@Override
	public void setBodyWidget(final Widget widget) {
		body.clear();
		body.add(widget);
	}

}