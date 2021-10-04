

$count = docker image ls amazoncorretto:16 | Select-String amazoncorretto | Measure-Object

if ($count.Count -ne 1) {
	docker pull amazoncorretto:16
}
$pwd = (Get-Location).Path

# Because Powershell doesn't support expanding a variable/expression with a colon immediately to its right... (parsed as member access) 
$mountarg = "$pwd","/class" -Join ":"

docker run -it -v "$mountarg" amazoncorretto:16
