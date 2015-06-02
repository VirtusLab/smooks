/*
 * Milyn - Copyright (C) 2006 - 2010
 * 
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License (version 2.1) as published
 * by the Free Software Foundation.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details:
 * http://www.gnu.org/licenses/lgpl.txt
 */
package org.milyn;

import java.io.IOException;
import java.io.InputStream;

import org.osgi.framework.Bundle;
import org.xml.sax.SAXException;

/**
 * A factory class for creating Smooks instances in an OSGi environment.
 * This factory will create create a class loader that is able to delegate
 * to the bundles classloader. 
 * 
 * @author Daniel Bevenius
 *
 */
public class SmooksOSGIFactory implements SmooksFactory
{
    private final Bundle bundle;

    public SmooksOSGIFactory(final Bundle bundle)
    {
        this.bundle = bundle;
    }

    public Smooks createInstance()
    {
        return createSmooksWithDelegatingClassloader();
    }
    
    public Smooks createInstance(final InputStream config) throws IOException, SAXException {
        final Smooks smooks = createSmooksWithDelegatingClassloader();
        if (config != null)
        {
	        smooks.addConfigurations(config);
        }
        return smooks;
    }
    
    private Smooks createSmooksWithDelegatingClassloader() {
        final Smooks smooks = new Smooks();
        smooks.setClassLoader(new BundleClassLoaderDelegator(bundle, getClass().getClassLoader()));
        return smooks;
    }

    public Smooks createInstance(String config) throws IOException, SAXException
    {
        final Smooks smooks = createSmooksWithDelegatingClassloader();
        if (config != null)
        {
	        smooks.addConfigurations(config);
        }
        return smooks;
    }
    
}
