#!/bin/bash

nohup /usr/local/app/play-sample-1.0-SNAPSHOT/bin/play-sample -J-Xms4G -J-Xmx4G -Dhttp.port=9000 -Dplay.crypto.secret=secret &

/bin/bash
