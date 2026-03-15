const { spawnSync } = require('child_process');
const path = require('path');

const rawArgs = process.argv.slice(2);
const headed = rawArgs.includes('--headed');
const dryRun = rawArgs.includes('--dry-run');
const filteredArgs = rawArgs.filter((arg) => arg !== '--headed' && arg !== '--dry-run');

if (filteredArgs.length === 0) {
  console.error('Usage: npm run cypress:spec -- <spec-name> [cypress args]');
  console.error('Example: npm run cypress:spec -- login --browser chrome');
  process.exit(1);
}

const [specInput, ...extraArgs] = filteredArgs;

const resolveSpecPath = (input) => {
  if (input.includes('/') || input.includes('\\')) {
    return input;
  }

  const normalizedName = input.replace(/(\.cy)?\.js$/i, '');
  return path.posix.join('cypress', 'e2e', `${normalizedName}.cy.js`);
};

const specPath = resolveSpecPath(specInput);
const cypressArgs = ['cypress', 'run'];

if (headed) {
  cypressArgs.push('--headed');
}

cypressArgs.push('--spec', specPath, ...extraArgs);

if (dryRun) {
  console.log(['npx', ...cypressArgs].join(' '));
  process.exit(0);
}

const result = spawnSync('npx', cypressArgs, {
  stdio: 'inherit',
  shell: true,
});

process.exit(result.status ?? 1);