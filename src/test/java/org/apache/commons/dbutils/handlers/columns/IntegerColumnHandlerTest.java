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
package org.apache.commons.dbutils.handlers.columns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IntegerColumnHandlerTest extends ColumnHandlerTestBase {
    public IntegerColumnHandlerTest() {
        super(new IntegerColumnHandler(), Integer.class);
    }

    @Test
    public void testMatchNegative() {
        assertFalse(handler.match(Float.class));
    }

    @Test
    public void testApplyType() throws Exception {
        when(rs.getInt(1)).thenReturn(Integer.MIN_VALUE);
        assertEquals(Integer.class, handler.apply(rs, 1).getClass());
    }
}