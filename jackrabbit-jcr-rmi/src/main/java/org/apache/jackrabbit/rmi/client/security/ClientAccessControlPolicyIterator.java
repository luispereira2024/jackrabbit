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
package org.apache.jackrabbit.rmi.client.security;

import javax.jcr.security.AccessControlPolicy;
import javax.jcr.security.AccessControlPolicyIterator;

import org.apache.jackrabbit.rmi.client.LocalAdapterFactory;
import org.apache.jackrabbit.rmi.client.iterator.ClientIterator;
import org.apache.jackrabbit.rmi.remote.RemoteIterator;
import org.apache.jackrabbit.rmi.remote.security.RemoteAccessControlList;

/**
 * @deprecated RMI support is deprecated and will be removed in a future version of Jackrabbit; see <a href=https://issues.apache.org/jira/browse/JCR-4972 target=_blank>Jira ticket JCR-4972</a> for more information.
 * <p>
 * A ClientIterator for iterating remote access control policies.
 */
@Deprecated(forRemoval = true) public class ClientAccessControlPolicyIterator extends ClientIterator implements
        AccessControlPolicyIterator {

    public ClientAccessControlPolicyIterator(RemoteIterator iterator,
            LocalAdapterFactory factory) {
        super(iterator, factory);
    }

    /** {@inheritDoc} */
    protected Object getObject(Object remote) {
        return getFactory().getAccessControlPolicy(
            (RemoteAccessControlList) remote);
    }

    /** {@inheritDoc} */
    public AccessControlPolicy nextAccessControlPolicy() {
        return (AccessControlPolicy) next();
    }
}
