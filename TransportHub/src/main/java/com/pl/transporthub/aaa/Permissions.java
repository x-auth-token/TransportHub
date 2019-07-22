/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.pl.transporthub.aaa;

public class Permissions {
	public enum Permission {

		/* Administrative Permissions */
		CREATE_USER, CHANGE_USER, DELETE_USER, VIEW_USER,

		CREATE_DRIVER, CHANGE_DRIVER, DELETE_DRIVER, VIEW_DRIVER,

		CREATE_PTM, CHANGE_PTM, DELETE_PTM, VIEW_PTM,

		CREATE_ADMIN, CHANGE_ADMIN, DELETE_ADMIN, VIEW_ADMIN,

		/* Application Permissions */

		CREATE_BUS, CHANGE_BUS, DELETE_BUS, VIEW_BUS,

		CREATE_LINE, CHANGE_LINE, DELETE_LINE, VIEW_LINE,

		CREATE_STATION, CHANGE_STATION, DELETE_STATION, VIEW_STATION,

		CREATE_ROUTE, CHANGE_ROUTE, DELETE_ROUTE, VIEW_ROUTE,

		CREATE_MAP, CHANGE_MAP, DELETE_MAP, VIEW_MAP;
	}
}
