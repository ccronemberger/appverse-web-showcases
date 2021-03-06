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
package org.appverse.web.showcases.gwtshowcase.gwtfrontend.admin.users.presenters.interfaces;

import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.view.LazyView;
import com.mvp4g.client.view.ReverseViewInterface;
import org.appverse.web.framework.backend.frontfacade.gxt.model.presentation.GWTPresentationPaginatedDataFilter;
import org.appverse.web.framework.backend.frontfacade.gxt.model.presentation.GWTPresentationPaginatedResult;
import org.appverse.web.framework.frontend.gwt.callback.AppverseCallback;
import org.appverse.web.framework.frontend.gwt.rpc.ApplicationAsyncCallback;
import org.appverse.web.showcases.gwtshowcase.backend.model.presentation.UserVO;

public interface UserSearchView extends
		ReverseViewInterface<UserSearchView.IUserSearchPresenter>, LazyView,
		IsWidget {

	interface IUserSearchPresenter {
		// Presenter methods that the view will use to communicate with the presenter here.
		void addUser();
		
		void editUser(UserVO user);
		
		public void loadUsers(
				GWTPresentationPaginatedDataFilter convert,
				AppverseCallback<GWTPresentationPaginatedResult<UserVO>> asyncCallback);

		void searchUsers();
		
		// Presenter methods to force presenter to implementation to implement the methods here.
		void onPlaceUserSearch();
		void onUsersSearch(boolean refresh);
	}

	// View methods here. The presenter will invoke this methods
	public void disableAddFeature();
	public void disableEditFeature();	
	public ApplicationAsyncCallback<GWTPresentationPaginatedResult<UserVO>> getCallbackListUsers();
	public GWTPresentationPaginatedDataFilter getDataFilter();
}