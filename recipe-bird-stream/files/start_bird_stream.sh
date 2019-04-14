#!/usr/bin/env sh

ALSA_DEVICE=default
ALSA_SAMPLE_RATE=48000
VIDEO_CODEC="h264"
AUDIO_CODEC=pcm_s32le
SCREEN_SIZE="640x480"
VIDEO_FILE="/dev/video0"
FRAME_RATE=15

FLV_AUDIO_CODEC=aac
FLV_VIDEO_CODEC=copy

if [[ ! -z ${STREAM_URL} ]]; then
arecord -D${ALSA_DEVICE} -fS32_LE -r${ALSA_SAMPLE_RATE} \
  | ffmpeg \
    -c:a ${AUDIO_CODEC} -i - \
    -f video4linux2 \
    -c:v ${VIDEO_CODEC} \
    -s ${SCREEN_SIZE} \
    -r ${FRAME_RATE} \
    -i ${VIDEO_FILE} \
    -c:a ${FLV_AUDIO_CODEC} \
    -ab 32k \
    -bufsize 32k \
    -f flv \
    -c:v ${FLV_VIDEO_CODEC} \
    ${STREAM_URL}
else
  echo "Set STREAM_URL in order to stream the video to a rtmp source"
fi
