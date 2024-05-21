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
package org.apache.pdfbox.util;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class StringUtil
{
    public static final Pattern PATTERN_SPACE = Pattern.compile("\\s");
    public static final Predicate<String> PREDICATE_SPACE = PATTERN_SPACE.asPredicate();

    public static String[] splitOnSpace(String s)
    {
        return PATTERN_SPACE.split(s);
    }

    /**
     * Split at spaces but keep them
     *
     * @param s
     * @return
     */
    public static String[] tokenizeOnSpace(String s)
    {
        return Arrays.stream(s.split("(?<=" + StringUtil.PATTERN_SPACE + ")|(?=" + StringUtil.PATTERN_SPACE + ")"))
                .toArray(String[]::new);
    }
}
