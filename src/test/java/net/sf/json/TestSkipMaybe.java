/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sf.json;

import java.util.HashMap;
import java.util.Map;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONFunction;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

/**
 * @author Andres Almiray <aalmiray@users.sourceforge.net>
 */
public class TestSkipMaybe extends TestCase {
   public static void main( String[] args ) {
      junit.textui.TestRunner.run( TestSkipMaybe.class );
   }

   public TestSkipMaybe( String testName ) {
      super( testName );
   }

/* place:key,value */
/* type:raw or string*/
/* value: [1,3],{a:2},null,800,function(){}*/
/* nest:1,2 */

   private String[] values={"[1,3]","{a:2}","null","800","-5","0","true","false","function(){}","undefined"};
   private String[] objStrings={
	"{obj:#}","{obj:'#'}",
	"{#:123}","{'#':123}",
	"{obj:{obj:#}}","{obj:{obj:'#'}}",
	"{obj:{#:123}}","{obj:{'#':123}}"};

   private void conv(String str){
       try{
          JSONObject obj = JSONObject.fromObject(str);
          System.out.println(str + "=>" +obj.toString());
       }catch(Throwable t){
          //t.printStackTrace();
          System.out.println(str + "=>error:"+t.getMessage());
       }
   }

   public void testX() {
       String JSONLIB_SKIPMAYBE = "jsonlib.skipMaybe";
       boolean skipMaybe=!"false".equals(System.getProperty(JSONLIB_SKIPMAYBE));
       System.out.println("skipMaybe:"+skipMaybe);
       for(String objString:objStrings){
           for(String value:values){
              String str=objString.replace("#",value);
              conv(str);
           }
       }
   }
   
   public void test1(){
       JSONObject obj = JSONObject.fromObject("{function(){}:123}}");
       System.out.println(obj.toString());
   }
   
   public void test2(){
       JSONObject obj = JSONObject.fromObject("{obj:{null:123}}");
       System.out.println(obj.toString());
   }
   
   
}