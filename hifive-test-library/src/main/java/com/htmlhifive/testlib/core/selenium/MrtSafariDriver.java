/*
 * Copyright (C) 2015 NS Solutions Corporation, All Rights Reserved.
 */

package com.htmlhifive.testlib.core.selenium;

import java.net.URL;

/**
 * Mac OS XのSafariで利用する{@link org.openqa.selenium.WebDriver}
 */
class MrtSafariDriver extends SplitScreenshotWebDriver {

	/**
	 * コンストラクタ
	 * 
	 * @param remoteAddress RemoteWebDriverServerのアドレス
	 * @param capabilities Capability
	 */
	MrtSafariDriver(URL remoteAddress, MrtCapabilities capabilities) {
		super(remoteAddress, capabilities);
	}

	@Override
	protected MrtWebElement newMrtWebElement() {
		return new MrtSafariWebElement();
	}

}
