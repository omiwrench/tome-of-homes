#!/usr/bin/env bash
set -e

if ! command -v brew >/dev/null; then
  echo "Homebrew missing. https://brew.sh/"
  exit 1
fi

if ! command -v node >/dev/null; then
  echo "Installing Node.js…"
  brew install node
fi

if [ ! -d "node_modules" ]; then
  echo "Initializing & installing express"
  npm init -y >/dev/null
  npm install express >/dev/null
fi

echo "Starting mock backend."
node mock-server.js