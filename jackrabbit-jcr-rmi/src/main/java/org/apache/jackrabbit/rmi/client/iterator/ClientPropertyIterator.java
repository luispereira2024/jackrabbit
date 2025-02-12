/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.rmi.client.iterator;

import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.Session;

import org.apache.jackrabbit.rmi.client.LocalAdapterFactory;
import org.apache.jackrabbit.rmi.remote.RemoteIterator;
import org.apache.jackrabbit.rmi.remote.RemoteProperty;

/**
 * @deprecated RMI support is deprecated and will be removed in a future version of Jackrabbit; see <a href=https://issues.apache.org/jira/browse/JCR-4972 target=_blank>Jira ticket JCR-4972</a> for more information.
 * <p>
 * A ClientIterator for iterating remote properties.
 */
@Deprecated(forRemoval = true) public class ClientPropertyIterator extends ClientIterator
        implements PropertyIterator {

    /** The current session. */
    private final Session session;

    /**
     * Creates a ClientPropertyIterator instance.
     *
     * @param iterator      remote iterator
     * @param session       current session
     * @param factory       local adapter factory
     */
    public ClientPropertyIterator(
            RemoteIterator iterator, Session session,
            LocalAdapterFactory factory) {
        super(iterator, factory);
        this.session = session;
    }

    /**
     * Creates and returns a local adapter for the given remote property.
     *
     * @param remote remote referecne
     * @return local adapter
     * @see ClientIterator#getObject(Object)
     */
    protected Object getObject(Object remote) {
        return getFactory().getProperty(session, (RemoteProperty) remote);
    }

    /**
     * Returns the next property in this iteration.
     *
     * @return next property
     * @see PropertyIterator#nextProperty()
     */
    public Property nextProperty() {
        return (Property) next();
    }

}
