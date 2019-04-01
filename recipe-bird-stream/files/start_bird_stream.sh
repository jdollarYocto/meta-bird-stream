#!/usr/bin/env sh

SCREEN_SIZE="640x480"
VIDEO_FILE="/dev/video0"
VIDEO_CODEC="h264"
FRAME_RATE=15

function twitch_stream {
  if [[ ! -z ${TWITCH_STREAM_KEY} ]]; then
    ffmpeg \
      -f video4linux2 \
      -s ${SCREEN_SIZE} \
      -r ${FRAME_RATE} \
      -vcodec ${VIDEO_CODEC} \
      -i ${VIDEO_FILE} \
      -codec copy \
      -f flv \
      "rtmp://live.twitch.tv/app/${TWITCH_STREAM_KEY}"
  else
    echo "Set TWITCH_STREAM_KEY to your twitch stream key from the dashboard"
  fi
}

function youtube_stream {
  echo "Not yet implemented"
}

case "$1" in
  "twitch")
    twitch_stream
    ;;
  "youtube")
    youtube_stream
    ;;
  *)
    echo "Pass in either twitch|youtube"
    ;;
esac

#ffmpeg -f video4linux2 -s 640x480 -r 15 -vcodec h264 -i /dev/video0 -codec copy -f flv "rtmp://live.twitch.tv/app/{twichKey}"                                                   
#ffmpeg -f video4linux2 -r 15 -vcodec h264 -f lavfi -i anullsrc=r=11025:cl=mono -i /dev/video0 -f flv "rtmp://a.rtmp.youtube.com/live2/{youtubeKey}"
#ffmpeg -f video4linux2 -r 15 -vcodec h264 -i /dev/video0 -f flv "rtmp://a.rtmp.youtube.com/live2/{youtubeKey}"
