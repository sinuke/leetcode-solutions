/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    let result = [];
    let chunk = [];

    for (let i = 0; i < arr.length; i++) {
        chunk.push(arr[i]);

        if (chunk.length === size || i === arr.length - 1) {
            result.push(chunk);
            chunk = [];
        }
    }

    return result;
};
