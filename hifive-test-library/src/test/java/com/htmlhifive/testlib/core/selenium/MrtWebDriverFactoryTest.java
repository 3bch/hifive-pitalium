/*
 * Copyright (C) 2015 NS Solutions Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.htmlhifive.testlib.core.selenium;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.htmlhifive.testlib.common.util.JSONUtils;

public class MrtWebDriverFactoryTest {

	@Test
	public void testGetInstance_InternetExplorer() throws Exception {
		TypeReference<List<Map<String, Object>>> reference = new TypeReference<List<Map<String, Object>>>() {
		};
		List<Map<String, Object>> maps = JSONUtils.readValue(
				getClass().getResourceAsStream("FactoryTest_capabilities.json"), reference);
		List<MrtCapabilities> caps = Lists.transform(maps, new Function<Map<String, Object>, MrtCapabilities>() {
			@Override
			public MrtCapabilities apply(Map<String, Object> input) {
				return new MrtCapabilities(input);
			}
		});

		assertThat(getFactoryName(caps.get(0)), is(containsString("internetexplorer")));
		assertThat(getFactoryName(caps.get(1)), is(containsString("internetexplorer")));
		assertThat(getFactoryName(caps.get(2)), is(containsString("internetexplorer")));
		assertThat(getFactoryName(caps.get(3)), is(containsString("internetexplorer8")));
		assertThat(getFactoryName(caps.get(4)), is(containsString("internetexplorer7")));
		assertThat(getFactoryName(caps.get(5)), is(containsString("chrome")));
		assertThat(getFactoryName(caps.get(6)), is(containsString("firefox")));
		assertThat(getFactoryName(caps.get(7)), is(containsString("safari")));
		assertThat(getFactoryName(caps.get(8)), is(containsString("chrome")));
		assertThat(getFactoryName(caps.get(9)), is(containsString("android")));
		assertThat(getFactoryName(caps.get(10)), is(containsString("selendroid")));
		assertThat(getFactoryName(caps.get(11)), is(containsString("ipad")));
		assertThat(getFactoryName(caps.get(12)), is(containsString("iphone")));
	}

	private String getFactoryName(MrtCapabilities capabilities) {
		return MrtWebDriverFactory.getInstance(capabilities).getClass().getSimpleName().toLowerCase();
	}

}