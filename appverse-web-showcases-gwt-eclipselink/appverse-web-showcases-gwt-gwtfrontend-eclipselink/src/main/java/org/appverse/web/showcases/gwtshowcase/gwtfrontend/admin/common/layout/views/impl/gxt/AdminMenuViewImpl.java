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
import org.appverse.web.showcases.gwtshowcase.gwtfrontend.admin.common.layout.presenters.interfaces.AdminMenuView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Singleton;

@Singleton
public class AdminMenuViewImpl extends
		ReverseComposite<AdminMenuView.IAdminMenuPresenter> implements
		AdminMenuView {

	interface BodyUiBinder extends UiBinder<Widget, AdminMenuViewImpl> {
	}

	private static BodyUiBinder uiBinder = GWT.create(BodyUiBinder.class);

	@UiField
	Label usersLink;
	@UiField
	Label homeLink;
    @UiField
    Label rolesLink;

	@Override
	public void createView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("usersLink")
	public void onUsersLinkClick(final ClickEvent event) {
		presenter.enterpriseUsersClicked();
	}
	
	
	@UiHandler("homeLink")
	public void onHomeLinkClick(final ClickEvent event) {
		presenter.homeClicked();
	}

    @UiHandler("rolesLink")
    public void onRolesLinkClick(final ClickEvent event) {
        presenter.rolesClicked();
    }
}