/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/main/resources/**/*.{html,js}"],
  theme: {
    extend: {},
  },
  darkMode: "class", // Use 'class' or 'media', 'selector' is invalid
  safelist: [
    // Green
    'text-green-800', 'border-green-300', 'bg-green-50', 'dark:text-green-400', 'dark:border-green-800',
    // Red
    'text-red-800', 'border-red-300', 'bg-red-50', 'dark:text-red-400', 'dark:border-red-800',
    // Yellow
    'text-yellow-800', 'border-yellow-300', 'bg-yellow-50', 'dark:text-yellow-400', 'dark:border-yellow-800',
    // Blue
    'text-blue-800', 'border-blue-300', 'bg-blue-50', 'dark:text-blue-400', 'dark:border-blue-800'
  ],
  plugins: [],
}

// /** @type {import('tailwindcss').Config} */
// module.exports = {
//   content: ["./src/main/resources/**/*.{html,js}"],
//   theme: {
//     extend: {},
//   },
//   plugins: [],
//   darkMode: "selector",
// }