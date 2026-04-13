mbti = input().strip()

opposite = {
    'I': 'E', 'E': 'I',
    'S': 'N', 'N': 'S',
    'T': 'F', 'F': 'T',
    'J': 'P', 'P': 'J'
}

result = ''.join(opposite[c] for c in mbti)

print(result)
