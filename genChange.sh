#!/bin/sh

echo "1" >> README.md
git add -A
git commit -m "test"
git push
