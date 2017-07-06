<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            div#grid_container{
                width:900px;
                margin: 0px auto;
                height:430px;
                border:#999 1px dashed;
				
                
            }
            div#grid_container > div{
                float:left;
                width:50px;
                border:#000 1px solid;
            }
            div#grid_container > div:nth-child(2n+0){
                background:#ffc910;
            }
            div#grid_container > div:nth-child(2n+1){
                background:#ffc910;
            }
            div#grid_container >div >div{ padding:20px;
            font-size:27px;
            color:#d9a800;}
            
            </style>
			<script>
                        var arrayList="";   
                        var newArrayList=["Null"];
                          newArrayList.splice(0,1);
                          
                        if("${seatData}"!="")  
                        arrayList=("${seatData}").split(",");
                        
                             function fillSeat(){
                                 
                              for(i=0;i<arrayList.length;i++)
                              {
                                  var div = document.getElementById(arrayList[i]);
                                    div.style.background="#ffffff";                      
                                    
                                  
                                  
                              }
                          }
                          
			
                        
                        
			function renderGrid(){
			
			for(i=0;i<102;i++)
			{
			var div = document.createElement("div");
			div.style.height="40px";
			div.id=i;
			div.addEventListener('click',function(){clickedFunction(this);},false);
			var content = document.createTextNode(i);
			div.appendChild(content);			
			document.getElementById("grid_container").appendChild(div);
                        
			}
                        
                        
                        fillSeat();
                        displayArrayList();
			}
			
			
			function clickedFunction(div){
			  
			  var available=0;
			  var i;
                          var check=0;
                         for(i=0;i<arrayList.length;i++)
                         {
                             
                             if(div.id==arrayList[i])
                             {
                                 check=1;
                             }
                                 
                          }
                         
                              
                          if(check==0)
                          {
				for(i=0;i<newArrayList.length;i++)
				{
					if(div.id==newArrayList[i])
					{
						available=1;
						break;
					}
				}
				if(available==1)
				{
                                    
					newArrayList.splice(i,1);
                                        div.style.background="#ffc910";
				}
				else
				{
				newArrayList.push(div.id);
                                  div.style.background="#00ff00";
				}
                                displayArrayList();
                             }
                        
        
                          
                          
}

			window.addEventListener("load",renderGrid,false);
                       
                        
			</script>
		
    </head>
    <body>
        
        <div id="grid_container">
		

<p id="demo"></p>

<script>
function displayArrayList() {
    document.getElementById("demo").innerHTML = "Already Booked Seats("+arrayList+")"+ newArrayList;
}
</script>
    
        </div>
        
        </body>
</html>
