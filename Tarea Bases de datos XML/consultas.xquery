xquery version "1.0";

(: 1. Mostrar cada uno de los nombres de los bailes con la etiqueta "losbailes" :)
let $result1 := 
<losbailes>
{
  for $baile in doc("fichero.xml")//baile
  return <nombre>{$baile/nombre}</nombre>
}
</losbailes>

(: 2. Mostrar los nombres de los bailes seguidos con el número de plazas entre paréntesis, ambos dentro de la misma etiqueta "losbailes" :)

let $result2 := 
<losbailes>
{
  for $baile in doc("fichero.xml")//baile
  return <bailes>{concat($baile/nombre, " (", $baile/plazas, ")")}</bailes>
}
</losbailes>

(: 3. Mostrar los nombres de los bailes cuyo precio sea mayor de 30 :)

let $result3 := 
<losbailes>
{
  for $baile in doc("fichero.xml")//baile
  where $baile/precio > 30
  return <nombre>{$baile/nombre}</nombre>
}
</losbailes>

(: 4. Mostrar los nombres y la fecha de comienzo de los bailes que comiencen en enero :)

let $result4 := 
<losbailes>
{
  for $baile in doc("fichero.xml")//baile
  where contains($baile/comienzo, "/1/")
  return <baile>
           <nombre>{$baile/nombre}</nombre>
           <comienzo>{$baile/comienzo}</comienzo>
         </baile>
}
</losbailes>

(: 5. Mostrar los nombres de los profesores y la sala en la que dan clase, ordenados por sala :)

let $result5 := 
<profesores>
{
  for $baile in doc("fichero.xml")//baile
  order by $baile/sala
  return <profesor>
           <nombre>{$baile/profesor}</nombre>
           <sala>{$baile/sala}</sala>
         </profesor>
}
</profesores>

(: 6. Mostrar cuántas plazas en total oferta el profesor "Jesus Lozano" :)

let $result6 := 
let $plazas := sum(
  for $baile in doc("fichero.xml")//baile
  where $baile/profesor = "Jesus Lozano"
  return $baile/plazas
)
return <plazas>{$plazas}</plazas>

(: 7. Mostrar el dinero que ganaría la profesora "Laura Mendiola" si se completaran todas las plazas de su baile :)

let $result7 := 
let $baile := doc("fichero.xml")//baile[profesor = "Laura Mendiola"]
let $total := $baile/plazas * $baile/precio
return <ganancia>{$total}</ganancia>

(: 8. Mostrar en una tabla de HTML los nombres de los bailes y su profesor :)

let $result8 := 
<html>
  <body>
    <table border="1">
      <tr>
        <th>Nombre del Baile</th>
        <th>Profesor</th>
      </tr>
      {
        for $baile in doc("fichero.xml")//baile
        return 
          <tr>
            <td>{$baile/nombre}</td>
            <td>{$baile/profesor}</td>
          </tr>
      }
    </table>
  </body>
</html>

return ($result1, $result2, $result3, $result4, $result5, $result6, $result7, $result8)
