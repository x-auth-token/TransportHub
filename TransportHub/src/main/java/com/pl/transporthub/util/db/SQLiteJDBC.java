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
package com.pl.transporthub.util.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC extends DataBase {

	private static String driverName = "jdbc:sqlite:";
	private static String url = "";
	private static File folder;
	
	private static final String scriptFile = "src/main/resources/sql/first_run_db.sql";

	public SQLiteJDBC() {

	}

	public SQLiteJDBC(String url) throws Exception {
		super(driverName, url);
	}

	public SQLiteJDBC(String folderName, String databaseFileName) throws Exception {



		folder = new File(folderName);

		if (!folder.exists())
			folder.mkdirs();

		url = driverName + folder.getAbsolutePath() + File.separator + databaseFileName;

		initialize(driverName, url);

	}
	
	
	
	public static void parseSqlFromScript() throws SQLException {
		String s            = new String();
        StringBuffer sb = new StringBuffer();
 
        try
        {
            FileReader fr = new FileReader(new File(scriptFile));
            
 
            BufferedReader br = new BufferedReader(fr);
 
            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();
 
           String[] inst = sb.toString().split(";");
        
            Statement st = getConnection().createStatement();
 
            for(int i = 0; i<inst.length; i++)
            {
                // we ensure that there is no spaces before or after the request string
                // in order to not execute empty statements
                if(!inst[i].trim().equals(""))
                {
                    st.executeUpdate(inst[i]);
                    System.out.println(">>"+inst[i]);
                }
            }}
            catch(Exception e)
            {
                System.out.println("*** Error : "+e.toString());
                System.out.println("*** ");
                System.out.println("*** Error : ");
                e.printStackTrace();
                System.out.println("################################################");
                System.out.println(sb.toString());
            }
	}
	
	
	
	 

}
