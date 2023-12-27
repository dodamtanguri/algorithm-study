const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input.push(line);
}).on('close', function () {
    const N = parseInt(input[0]); // Length of the street
    const lights = input[2].split(' ').map(Number);

    const answer = solve(N, lights);
    console.log(answer);

    process.exit();
});

function solve(N, lights) {
    let left = 0, right = N;
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (isEnough(mid, N, lights)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;
}

function isEnough(height, N, lights) {
    let last = 0;
    for (const light of lights) {
        if (light - height > last) {
            return false;
        }
        last = light + height;
    }
    return last >= N;
}
