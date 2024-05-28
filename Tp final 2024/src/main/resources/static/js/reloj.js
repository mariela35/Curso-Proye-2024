function actReloj(){
   let hhmmss=new Date();
   let horas=hhmmss.getHours();
   let minutos=hhmmss.getMinutes();
   let segundos=hhmmss.getSeconds();
   let lahora="";
   //Convertimos los números a dos dígitos, o sea, 6 -> 06
   horas = (horas<=9)?("0"+horas):horas;
   minutos = (minutos<=9)?("0"+minutos):minutos;
   segundos=(segundos<=9)? ("0"+segundos):segundos;        
   //Aquí construimos la cadena de texto HTML con la hora,
   //y el tipo de letra que se escribe en la capa del reloj.
   lahora = horas+":"+minutos+":" +segundos
   reloj = document.getElementById('reloj')
   reloj.innerHTML=lahora;
   //ejecuta la función cada segundo (1000 miliseg)
   setTimeout("actReloj()",1000);
}
