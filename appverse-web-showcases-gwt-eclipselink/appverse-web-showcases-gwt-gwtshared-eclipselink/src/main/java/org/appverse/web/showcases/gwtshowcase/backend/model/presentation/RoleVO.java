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
package org.appverse.web.showcases.gwtshowcase.backend.model.presentation;

import org.appverse.web.framework.backend.frontfacade.gxt.model.presentation.GWTAbstractPresentationAuditedBean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

public class RoleVO extends GWTAbstractPresentationAuditedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2623521933606397996L;

	private long id;

	/*
	 * // Validation group for delete operation public interface DeleteGroup {
	 * };
	 */

	@Size(min = 1, max = 40, groups = { Default.class })
	@NotNull
	private String name;

	@Size(max = 200, groups = { Default.class })
	private String description;

	private String listPermissions;

	private String listEnvironments;

	/*
	 * @AssertFalse(groups = { DeleteGroup.class })
	 */
	private boolean active = true;


	public RoleVO() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public long getId() {
		return id;
	}

	public String getListEnvironments() {
		return listEnvironments;
	}

	public String getListPermissions() {
		return listPermissions;
	}

	public String getName() {
		return name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setListEnvironments(final String listEnvironments) {
		this.listEnvironments = listEnvironments;
	}

	public void setListPermissions(final String listPermissions) {
		this.listPermissions = listPermissions;
	}

	public void setName(final String name) {
		this.name = name;
	}
}
