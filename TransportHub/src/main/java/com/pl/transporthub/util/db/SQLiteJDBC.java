/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
