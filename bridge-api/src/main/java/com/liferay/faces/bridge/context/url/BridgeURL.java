/**
 * Copyright (c) 2000-2015 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.bridge.context.url;

import java.util.Map;
import java.util.Set;

import javax.faces.component.UIViewRoot;
import javax.portlet.PortletURL;
import javax.portlet.faces.Bridge;


/**
 * This interface represents a bridge URL, meaning a URL that has convenience methods for representing URLs according to
 * Section 6.1.3.1 of the Bridge Spec.
 *
 * @author  Neil Griffin
 */
public interface BridgeURL {

	/**
	 * Removes the value of the underlying {@link BridgeURL#getParameterMap()} with the specified <code>name</code>.
	 */
	public String removeParameter(String name);

	/**
	 * Returns a string-based representation of the URL. If {@link BridgeURL#isEscaped()} returns true then the value
	 * returned by this method will contain escaped characters.
	 */
	@Override
	public String toString();

	/**
	 * Returns the context-relative path in the URL. If no path is found, then the current Faces viewId (found in the
	 * current {@link UIViewRoot}) is returned.
	 */
	public String getContextRelativePath();

	/**
	 * Determines whether or not the URL is escaped.
	 *
	 * @return  <code>true</code> if all occurrences of the ampersand character appear as &amp; otherwise, returns
	 *          <code>false</code>.
	 */
	public boolean isEscaped();

	/**
	 * Determines whether or not the URL is absolute.
	 *
	 * @return  <code>true</code> if absolute, otherwise <code>false</code>
	 */
	public boolean isAbsolute();

	/**
	 * Determines whether or not the URL is opaque, meaning it is absolute and its scheme component does not begin with
	 * a forward-slash character. For more information see {@link java.net.URI#isOpaque()}.
	 *
	 * @return  <code>true</code> if the URL is opaque, otherwise <code>false</code>.
	 */
	public boolean isOpaque();

	/**
	 * Determines whether or not the path component of the URL is relative, meaning it does not begin with a
	 * forward-slash character.
	 *
	 * @return  <code>true</code> if the path is relative, otherwise <code>false</code>.
	 */
	public boolean isPathRelative();

	/**
	 * Determines whether or not the URL begins with the "portlet:" scheme.
	 *
	 * @return  <code>true</code> if the URL begins with the "portlet:" scheme, otherwise <code>false</code>.
	 */
	public boolean isPortletScheme();

	/**
	 * Flag indicating whether or not the URL is secure. For more information, see {@link
	 * PortletURL#setSecure(boolean)}.
	 *
	 * @return  <code>true</code> if the URL is secure, otherwise <code>false</code>.
	 */
	public boolean isSecure();

	/**
	 * Determines whether or not the URL is self-referencing, meaning, it targets the current Faces view.
	 *
	 * @return  <code>true</code> if self-referencing, otherwise <code>false</code>.
	 */
	public boolean isSelfReferencing();

	/**
	 * Determines whether or not the URL is external.
	 *
	 * @return  <code>true</code> if external, otherwise <code>false</code>.
	 */
	public boolean isExternal();

	/**
	 * Determines whether or not the URL is hierarchical, meaning it is either 1) absolute and the scheme-specific part
	 * begins with a forward-slash character, or 2) is relative.
	 *
	 * @return  <code>true</code> if the URL is hierarchical, otherwise <code>false</code>.
	 */
	public boolean isHierarchical();

	/**
	 * Returns the value of the underlying {@link BridgeURL#getParameterMap()} with the specified <code>name</code>.
	 */
	public String getParameter(String name);

	/**
	 * Sets the <code>value</code> of the underlying {@link BridgeURL#getParameterMap()} according to the specified
	 * <code>name</code>.
	 */
	public void setParameter(String name, String value);

	/**
	 * Sets the <code>value</code> of the underlying {@link BridgeURL#getParameterMap()} according to the specified
	 * <code>name</code>.
	 */
	public void setParameter(String name, String[] value);

	/**
	 * Returns a mutable {@link Map} representing the URL parameters.
	 */
	public Map<String, String[]> getParameterMap();

	/**
	 * Returns a list of key names from the underlying {@link BridgeURL#getParameterMap()}.
	 */
	public Set<String> getParameterNames();

	/**
	 * Returns the {@link Bridge.PortletPhase} associated with this URL. Note that the value will be null if the URL
	 * does not begin with the "portlet:" scheme/prefix.
	 */
	public Bridge.PortletPhase getPortletPhase();

	/**
	 * Sets the flag indicating whether or not the URL is secure.
	 *
	 * @param  secure  <code>true</code> if secure, otherwise <code>false</code>.
	 */
	public void setSecure(boolean secure);

	/**
	 * Sets the flag indicating whether or not the URL is self-referencing, meaning, whether or not it targets the
	 * current Faces view.
	 *
	 * @param  selfReferencing  <code>true</code> if self-referencing, otherwise <code>false</code>.
	 */
	public void setSelfReferencing(boolean selfReferencing);

	/**
	 * Determines whether or not the URL targets a Faces View.
	 *
	 * @return  <code>true</code> if the URL targets a Faces View, otherwise <code>false</code>
	 */
	public boolean isFacesViewTarget();
}
