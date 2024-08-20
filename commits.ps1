

git status

Write-Host "ingrese (y) para hacer el commit: " -ForegroundColor Magenta -NoNewline
$confirm = Read-Host  

if ($confirm -eq "y") {
    Write-Host "ingrese el mensaje del commit: " -ForegroundColor Magenta -NoNewline
    $Mensaje = Read-Host
   
    git add src/main/resources/templates
    git add src/main/java/com/nPants/nPants
   
    git commit -m $Mensaje
    git push 
}

     

   


