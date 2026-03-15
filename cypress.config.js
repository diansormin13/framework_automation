const { defineConfig } = require('cypress');
const fs = require('fs');
const path = require('path');

module.exports = defineConfig({
  reporter: 'mochawesome',
  reporterOptions: {
    reportDir: 'cypress/results',
    overwrite: false,
    html: true,
    json: true,
  },
  e2e: {
    baseUrl: 'https://www.saucedemo.com',
    specPattern: 'cypress/e2e/**/*.cy.js',
    supportFile: 'cypress/support/e2e.js',
    trashAssetsBeforeRuns: false,
    setupNodeEvents(on, config) {
      const moveLatestResultFile = (resultsDir, extension, targetDir, targetBaseName) => {
        if (!fs.existsSync(resultsDir)) {
          return;
        }

        const pattern = new RegExp(`^mochawesome(?:_\\d+)?\\.${extension}$`, 'i');
        const candidates = fs
          .readdirSync(resultsDir)
          .filter((fileName) => pattern.test(fileName))
          .map((fileName) => {
            const fullPath = path.join(resultsDir, fileName);
            return {
              fullPath,
              mtimeMs: fs.statSync(fullPath).mtimeMs,
            };
          })
          .sort((a, b) => b.mtimeMs - a.mtimeMs);

        if (candidates.length === 0) {
          return;
        }

        const source = candidates[0].fullPath;
        let target = path.join(targetDir, `${targetBaseName}.${extension}`);

        if (source === target) {
          return;
        }

        let counter = 1;
        while (fs.existsSync(target)) {
          target = path.join(targetDir, `${targetBaseName}-${counter}.${extension}`);
          counter += 1;
        }

        fs.renameSync(source, target);
      };

      on('after:spec', (spec, results) => {
        const timestamp = new Date().toISOString().replace(/[:.]/g, '-');
        const specName = path.basename(spec.relative);
        const resultsDir = path.join(config.projectRoot, 'cypress', 'results');
        const runFolderName = `${specName}-${timestamp}`;
        const runDir = path.join(resultsDir, runFolderName);
        const jsonDir = path.join(runDir, 'json');
        const htmlDir = path.join(runDir, 'html');

        fs.mkdirSync(jsonDir, { recursive: true });
        fs.mkdirSync(htmlDir, { recursive: true });

        moveLatestResultFile(resultsDir, 'json', jsonDir, runFolderName);
        moveLatestResultFile(resultsDir, 'html', htmlDir, runFolderName);

        const htmlAssetsSource = path.join(resultsDir, 'assets');
        const htmlAssetsTarget = path.join(htmlDir, 'assets');
        if (fs.existsSync(htmlAssetsSource)) {
          fs.cpSync(htmlAssetsSource, htmlAssetsTarget, { recursive: true });
        }

        if (results && results.video && fs.existsSync(results.video)) {
          const parsedVideoPath = path.parse(results.video);
          const compressedVideoPath = path.join(
            parsedVideoPath.dir,
            `${parsedVideoPath.name}-compressed${parsedVideoPath.ext}`
          );
          let targetVideoPath = path.join(
            parsedVideoPath.dir,
            `${parsedVideoPath.name}-${timestamp}${parsedVideoPath.ext}`
          );

          if (targetVideoPath !== results.video) {
            let counter = 1;
            while (fs.existsSync(targetVideoPath)) {
              targetVideoPath = path.join(
                parsedVideoPath.dir,
                `${parsedVideoPath.name}-${timestamp}-${counter}${parsedVideoPath.ext}`
              );
              counter += 1;
            }

            fs.renameSync(results.video, targetVideoPath);
          }

          if (fs.existsSync(compressedVideoPath)) {
            fs.rmSync(compressedVideoPath, { force: true });
          }
        }
      });

      config.browsers = config.browsers.filter(({ name }) => {
        return ['chrome', 'edge'].includes(name);
      });

      return config;
    },
    video: true,
    videoCompression: false,
    videosFolder: 'cypress/videos',
    screenshotOnRunFailure: true,
    screenshotsFolder: 'cypress/screenshots',
    viewportWidth: 1440,
    viewportHeight: 900,
  },
});