b=http://webcam.frauenkirche.de/webcams/img.php
ua="Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/601.4.4 (KHTML, like Gecko) Version/9.0.3 Safari/601.4.4"
while[ 1 ]do
 date;a=`curl https://floatingboat2013.appspot.com/at`
 curl -A "$ua" $b\?12 > ~/Desktop/FrauenCam12At$a.jpg
 curl -A "$ua" http://webcam.frauenkirche.de/webcams/img.php\?22 > ~/Desktop/FrauenCam22At$a.jpg
 curl -A "$ua" http://webcam.frauenkirche.de/webcams/img.php\?32 > ~/Desktop/FrauenCam32At$a.jpg
 sleep 25
done 