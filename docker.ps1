

$count = docker image ls amazoncorretto:20 | Select-String amazoncorretto | Measure-Object

if ($count.Count -ne 1) {
	docker pull amazoncorretto:20
}
$pwd = (Get-Location).Path

# Because Powershell doesn't support expanding a variable/expression with a colon immediately to its right... (parsed as member access) 
$mountarg = "$pwd","/class" -Join ":"

docker run -it -v "$mountarg" amazoncorretto:20
