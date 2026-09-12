# PowerShell build script for Shadeer mod
# This script provides a simple way to verify the project structure

Write-Host "Shadeer Mod Build Verification" -ForegroundColor Green
Write-Host "=============================" -ForegroundColor Green

# Check project structure
Write-Host "Checking project structure..." -ForegroundColor Yellow

$requiredDirs = @(
    "src/main/java/com/shadeer",
    "src/main/resources/assets/shadeer",
    "src/main/resources/data/shadeer",
    "gradle"
)

$missingDirs = @()
foreach ($dir in $requiredDirs) {
    if (-not (Test-Path $dir)) {
        $missingDirs += $dir
    }
}

if ($missingDirs.Count -eq 0) {
    Write-Host "OK: All required directories exist" -ForegroundColor Green
} else {
    Write-Host "ERROR: Missing directories:" -ForegroundColor Red
    foreach ($dir in $missingDirs) {
        Write-Host "  - $dir" -ForegroundColor Red
    }
}

# Check key files
Write-Host "`nChecking key files..." -ForegroundColor Yellow

$requiredFiles = @(
    "build.gradle",
    "gradle.properties",
    "settings.gradle",
    "src/main/resources/fabric.mod.json",
    "src/main/java/com/shadeer/ShadeerMod.java"
)

$missingFiles = @()
foreach ($file in $requiredFiles) {
    if (-not (Test-Path $file)) {
        $missingFiles += $file
    }
}

if ($missingFiles.Count -eq 0) {
    Write-Host "OK: All required files exist" -ForegroundColor Green
} else {
    Write-Host "ERROR: Missing files:" -ForegroundColor Red
    foreach ($file in $missingFiles) {
        Write-Host "  - $file" -ForegroundColor Red
    }
}

# Count Java files
Write-Host "`nCounting Java source files..." -ForegroundColor Yellow
$javaFiles = Get-ChildItem -Path "src/main/java" -Filter "*.java" -Recurse -ErrorAction SilentlyContinue
$javaCount = if ($javaFiles) { $javaFiles.Count } else { 0 }
Write-Host "Found $javaCount Java source files" -ForegroundColor Green

# Count resource files
Write-Host "`nCounting resource files..." -ForegroundColor Yellow
$resourceFiles = Get-ChildItem -Path "src/main/resources" -Recurse -File -ErrorAction SilentlyContinue
$resourceCount = if ($resourceFiles) { $resourceFiles.Count } else { 0 }
Write-Host "Found $resourceCount resource files" -ForegroundColor Green

Write-Host "`nBuild verification complete!" -ForegroundColor Green
Write-Host "To build the mod, run: ./gradlew build" -ForegroundColor Cyan
Write-Host "To run in development, run: ./gradlew runClient" -ForegroundColor Cyan